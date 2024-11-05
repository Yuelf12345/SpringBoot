<template>
    <div>
        <el-sub-menu :index="route.path" v-if="route.children">
            <template #title>
                <el-icon>
                    <component :is="route.meta?.title ||'location'" />
                </el-icon>
                <span>{{ route.meta?.title || route.name }}</span>
            </template>
            <template v-for="child in route.children" :key="child.path">
                <AsideItem :route="child" />
            </template>
        </el-sub-menu>
        <el-menu-item :index="route.path" v-else>
            <template #title>
                <el-icon>
                    <component :is="route.meta?.title ||'location'" />
                </el-icon>
                <span>{{ route.meta?.title || route.name }}</span>
            </template>
        </el-menu-item>
    </div>
</template>
<script lang="ts" setup>
import { PropType } from 'vue';
import { RouteRecordRaw } from 'vue-router';
defineProps({
    route: {
        type: Object as PropType<RouteRecordRaw>,
        required: true,
    },
})
</script>