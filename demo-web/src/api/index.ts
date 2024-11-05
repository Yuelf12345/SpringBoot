import request from "@/utils/request";
export function login() {
  return request({
    url: "login",
    method: "POST",
    data: {
      username: "张三",
      password: "123",
    },
  });
}
