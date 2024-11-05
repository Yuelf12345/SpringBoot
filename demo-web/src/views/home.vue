<script lang="ts" setup>
import { login } from '@/api/index'
const handleLogin = () => {
    login().then(res => {
        console.log('res', res)
    })
}
</script>

<template>
    <div>
        home
        <el-button @click="handleLogin">login</el-button>
    </div>
</template>