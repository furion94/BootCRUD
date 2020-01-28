import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

class base {
    listBoard() {
        return axios.get(BASE_URL +'/list');
    }

    detailBoard(board_number){
        return axios.get(BASE_URL + '/select/' + board_number);
    }

    deleteBoard(board_number){
        return axios.get(BASE_URL + '/delete/' + board_number);
    }

    insertBoard(){
        const writer = document.getElementById('writer').value;
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        return axios.post(BASE_URL + '/insert/'+writer+'/'+title+'/'+content);
    }

    updateBoard(board_number){
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        return axios.post(BASE_URL + '/update/'+board_number+'/'+title+'/'+content);
    }
}

export default new base();

