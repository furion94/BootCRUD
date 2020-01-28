import React from 'react'
import ReactDOM from 'react-dom';
import base from "./base";

class List extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            board: [],
            detailBoard: [],
            now: 'list'
        }
    }

    componentDidMount() {
        this.reloadList();
    }

    reloadList = () => {
        this.clearValue();
        base.listBoard().then(res => {
            this.setState({board: res.data});
            this.setState({now: 'list'});
        });
    }

    detailBoard = (board_number) => {
        this.setState({now: 'detail'});
        base.detailBoard(board_number).then(res => {
            this.setState({detailBoard: res.data});
        });
    }

    deleteBoard = (board_number) => {
        base.deleteBoard(board_number);
        this.reloadList();
    }

    insertBoardForm = () =>{
        this.setState({now: 'insert'})
    }

    insertBoard = () => {
        base.insertBoard();
        this.reloadList();
    }

    updateBoard = (board_number) => {
        base.updateBoard(board_number);
        this.reloadList();
    }

    onChangeValue = (e) => {
        let changeValue = this.state.detailBoard;
        changeValue[e.target.name] = e.target.value;
        this.setState({changeValue});
    }

    clearValue = () => {
        this.setState({board: []});
        this.setState({detailBoard: []});
        this.setState({now: null});
    }

    render() {
        if(this.state.now == 'list'){
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
                            this.state.board.map((list, index) =>
                                <tr key={index}>
                                    <td>{list.board_number}</td>
                                    <td onClick={() => this.detailBoard(list.board_number)}>{list.title}</td>
                                    <td>{list.writer}</td>
                                    <td>
                                        <button className="btn btn-success" onClick={() => this.deleteBoard(list.board_number)}>Delete</button>
                                    </td>
                                </tr>)
                        }
                        </tbody>
                    </table>
                    <button className="btn btn-success" onClick={() => this.insertBoardForm()}>글쓰기</button>
                </div>
            );
        }else if(this.state.now == 'insert'){
            return(
                <div>
                    <table>
                        <tbody>
                            <tr>
                                <th>
                                    작성자
                                </th>
                                <td>
                                    <input type='text' id='writer'/>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    제목
                                </th>
                                <td>
                                    <input type='text' id='title'/>
                                </td>
                            </tr>
                            <tr>
                                <th>
                                    내용
                                </th>
                                <td>
                                    <textarea id='content'></textarea>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <button className="btn btn-success" onClick={() => this.insertBoard()}>작성완료</button>
                    <button className="btn btn-success" onClick={() => this.reloadList()}>돌아가기</button>
                </div>
            );
        }else if(this.state.now == 'detail'){
            return(
                <div>
                    상세조회
                    <table>
                        <tbody>
                            <tr>
                                <th>글번호</th>
                                <td>{this.state.detailBoard.board_number}</td>
                            </tr>
                            <tr>
                                <th>제목</th>
                                <td><input type='text' id='title' name="title" onChange={this.onChangeValue} value={this.state.detailBoard.title||''}/></td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>{this.state.detailBoard.writer}</td>
                            </tr>
                            <tr>
                                <th>내용</th>
                                <td><textarea id='content' name='content' value={this.state.detailBoard.content||''} onChange={this.onChangeValue}></textarea></td>
                            </tr>
                            <tr>
                                <td colSpan='2'>
                                    <button className="btn btn-success" onClick={() => this.updateBoard(this.state.detailBoard.board_number)}>수정</button>
                                    <button className="btn btn-success" onClick={() => this.reloadList()}>돌아가기</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            );
        }else{
            return(
                <div>
                화면로딩중
               </div>
            );
        }
    }
}

ReactDOM.render(<List/>, document.getElementById('root'));
