import axios, {
  AxiosInstance,
  AxiosRequestConfig,
  InternalAxiosRequestConfig,
} from "axios";
export interface ResponseError extends Error {
  config: AxiosRequestConfig;
  request: AxiosPromise;
  response: AxiosResponse;
}

export interface AxiosResponse {
  data: any;
  headers: any;
  ok: boolean;
  request: AxiosPromise;
  status: number;
  statusText: string;
  url: string;
}

export interface AxiosPromise extends Promise<AxiosResponse> {
  cancel(callback?: () => void): void;
  clearTimeout(timeout?: number): void;
  config: AxiosRequestConfig;
}

const BASE_URL = "http://localhost:5173/api";
const REQUEST_TIMEOUT = 1000 * 10;

const service: AxiosInstance = axios.create({
  baseURL: BASE_URL,
  timeout: REQUEST_TIMEOUT,
  headers: {
    // 'Content-Type': 'application/json',
    Accept: "application/json",
    Authorization: `Bearer ${localStorage.getItem("y_t")}`,
  },
});

// 请求拦截
service.interceptors.request.use(
  (config: InternalAxiosRequestConfig) => {
    console.log("config.url", config.url);
    if (config.url && config.url.indexOf("/refresh_token") === -1) {
      config.headers.Authorization = `Bearer ${localStorage.getItem("y_t")}`;
    }
    return config;
  },
  (error: ResponseError) => {
    console.log("!请求接口错误", error);
    return Promise.reject();
  }
);

//响应拦截
service.interceptors.response.use(
  async (response) => {
    return response.data;
  },
  (error: ResponseError) => {
    console.log("!响应接口错误", error);
    return Promise.reject();
  }
);

export default service;
