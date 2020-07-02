const axios = require("axios");

const instanceAxios = axios.create({
  baseURL: "http://localhost:8080/",
});

function sleep(delay, value) {
  return new Promise(function (resolve) {
    setTimeout(resolve, delay, value);
  });
}

instanceAxios.interceptors.response.use(
  function (response) {
    const { data } = response;
    console.log("data", data);
    
    if (data.code !== 0) {
      const error = new Error(data.message || "Unknow Error.");
      error.data = data.data;
      throw error;
    }
    return sleep(500, data.data);
  },
  function (error) {
    return Promise.reject(error);
  }
);

export { instanceAxios };
