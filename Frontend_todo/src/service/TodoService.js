import axios from "axios";


const APP_URL = "http://localhost:8059/api/v1/todo";
const APP_URL_Pending = "http://localhost:8059/api/v1/todo/status_pending";
const APP_URL_Completed = "http://localhost:8059/api/v1/todo/status_complete";

class TodoService {

    deleteAll() {
        return axios.delete(APP_URL);
    }

    deleteCompleted(){
        return axios.delete(APP_URL_Completed);
    }

    deletePending() {
        return axios.delete(APP_URL_Pending);
    }

    getAllCompleted() {
        return axios.get(APP_URL_Completed);
    }

    getAllPending() {
        return axios.get(APP_URL_Pending);
    }

    getAllTasks() {
        return axios.get(APP_URL);
    }

    getTask(id) {
        return axios.get(`${APP_URL}/${id}`);
    }

    deleteTask(id) {
        return axios.delete(`${APP_URL}/${id}`);
    }

    createTask(todo){
        return axios.post(APP_URL, todo);
    }

    updateTask(id, task) {
        return axios.put(`${APP_URL}/${id}`, task  );
    }

}

// eslint-disable-next-line
export default new TodoService();