<script lang="ts" setup>
import { get1,get2,post1, post2, post3 } from '@/api/index'
const onGet1 = () => {
  get1().then(res => {
    console.log('res', res)
  })
}
const onGet2 = () => {
  get2().then(res => {
    console.log('res', res)
  })
}
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
      <el-button @click="onGet1">RequestParam</el-button>
      <el-button @click="onGet2">PathVariable</el-button>
        <el-button @click="onPost1">entityClass</el-button>
        <el-button @click="onPost2">entityArray</el-button>
        <el-button @click="onPost3">entityMap</el-button>
    </div>
</template>