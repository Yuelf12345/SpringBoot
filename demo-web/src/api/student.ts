import request from "@/utils/request";

export const getStudentList = () => {
  return request({
    url: "/student/list",
    method: "GET"
  });
}

export const getStudentInfo = id => {
  return request({
    url: `/student/${id}`,
    method: "GET"
  });
}