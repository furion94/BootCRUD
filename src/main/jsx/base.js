import axios from 'axios';

const BASE_URL = 'http://localhost:8080';

class base {
    listBoard() {
        return axios.get(BASE_URL +'/list');
    }

    detailBoard(board_number){
        console.log(board_number);
        return axios.get(BASE_URL + '/select?num=' + board_number);
    }

    deleteBoard(board_number){
        return axios.get(BASE_URL + '/delete?num=' + board_number);
    }
}

export default new base();