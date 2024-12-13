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
          path: "/test",
          name: "Test",
          component: () => import("@/views/test.vue"),
        }
      ],
    },
  ];
  
  const router: Router = createRouter({
    history: createWebHistory(),
    routes: constantRoutes,
  });
  
  export default router;
  