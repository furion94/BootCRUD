import React from 'react'
import ReactDOM from 'react-dom';
import base from "./base";

class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            board: []
        }
        this.reloadList = this.reloadList.bind(this);
        this.detailBoard = this.detailBoard.bind(this);
        this.deleteBoard = this.deleteBoard.bind(this);
    }

    componentDidMount() {
        this.reloadList();
    }

    reloadList(){
        base.listBoard().then(res => {
            this.setState({board: res.data.boardList})
        });
    }

    detailBoard(board_number){
        base.detailBoard(board_number).then(res => {
            this.setState({board: res.data.boardList})
        });
    }

    deleteBoard(board_number){
        base.deleteBoard(board_number);
        this.reloadList();
    }

    render() {
        return (
            <div>
                <table>
                    <thead>
                        <tr>
                            <th>글 번호</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                        this.state.board.map(list =>
                                <tr>
                                    <td>{list.board_number}</td>
                                    <td>{list.content}</td>
                                    <td>{list.writer}</td>
                                    <td>
                                        <button className="btn btn-success" onClick={() => this.deleteBoard(list.board_number)}>Delete</button>
                                    </td>
                                </tr>)
                       }
                    </tbody>
                </table>
            </div>
        );
    }
}

ReactDOM.render(<List/>, document.getElementById('root'));
