import request from "@/utils/request";

export const addUser = (data:any) => {
  return request({
    url: "/user",
    method: "POST",
    data
  });
}