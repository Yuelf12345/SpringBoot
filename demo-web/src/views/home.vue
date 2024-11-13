<script lang="ts" setup>
import { post1, post2, post3 } from '@/api/index'
const onPost1 = () => {
  post1().then(res => {
        console.log('res', res)
    })
}
const onPost2 = () => {
  post2().then(res => {
    console.log('res', res)
  })
}

const onPost3 = () => {
  post3().then(res => {
    console.log('res', res)
  })
}
</script>

<template>
    <div>
        home
        <el-button @click="onPost1">entityClass</el-button>
        <el-button @click="onPost2">entityArray</el-button>
        <el-button @click="onPost3">entityMap</el-button>
    </div>
</template>