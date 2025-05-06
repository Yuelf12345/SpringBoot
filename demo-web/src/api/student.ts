import request from "@/utils/request";

export const getStudentList = () => {
  return request({
    url: "/student/list",
    method: "GET"
  });
}