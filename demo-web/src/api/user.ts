import request from "@/utils/request";

export const addUser = (data:any) => {
  return request({
    url: "/user",
    method: "POST",
    data
  });
}

export const getUser = (id:number) => {
  return request({
    url: `/user/${id}`,
    method: "GET"
  });
}

export const updatedUser = (data:any) => {
  return request({
    url: "/user",
    method: "PUT",
    data
  });
}

export const deleteUser = (id:number) => {
  return request({
    url: `/user/${id}`,
    method: "DELETE"
  });
}