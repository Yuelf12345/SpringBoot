import {
    createRouter,
    createWebHistory,
    Router,
    RouteRecordRaw,
  } from "vue-router";
  
  const Layout = () => import("@/layout/index.vue");
  
  export const constantRoutes: Array<RouteRecordRaw> = [
    {
      path: "/",
      name: "index",
      redirect: "/home",
      component: Layout,
      children: [
        {
          path: "/home",
          name: "Home",
          component: () => import("@/views/home.vue"),
        },
        {
          path: "/student",
          name: "Student",
          component: () => import("@/views/student.vue"),
        },
        {
          path: "/test",
          name: "Test",
          component: () => import("@/views/test.vue"),
        },
        {
          path: "/user",
          name: "User",
          component: () => import("@/views/user.vue"),
        }
      ],
    },
  ];
  
  const router: Router = createRouter({
    history: createWebHistory(),
    routes: constantRoutes,
  });
  
  export default router;
  