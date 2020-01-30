import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

class base {
    listBoard() {
        return axios.get(BASE_URL +'/board');
    }

    detailBoard(board_number){
        return axios.get(BASE_URL + '/board/' + board_number);
    }

    deleteBoard(board_number){
        return axios.delete(BASE_URL + '/board/' + board_number);
    }

    insertBoard(){
        const writer = document.getElementById('writer').value;
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        return axios.post(BASE_URL + '/board/'+writer+'/'+title+'/'+content);
    }

    updateBoard(board_number){
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        return axios.put(BASE_URL + '/board/'+board_number+'/'+title+'/'+content);
    }
}

export default new base();

