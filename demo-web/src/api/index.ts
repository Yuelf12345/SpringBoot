import request from "@/utils/request";

export function get1() {
  return request({
    url: "/get1",
    method: "GET",
    params: {
      username: "张三",
      password: "123",
    },
  });
}

export function get2() {
  return request({
    url: "/get2/zs",
    method: "GET",
  });
}

export function post1() {
  return request({
    url: "/post1",
    method: "POST",
    data: {
      username: "张三",
      password: "123",
    },
  });
}

export function post2() {
  return request({
    url: "/post2",
    method: "POST",
    data: ['张三','李四','王五'],
  });
}

export function post3() {
  return request({
    url: "/post3",
    method: "POST",
    data: {
      username: "张三",
      password: "123",
    },
  });
}

