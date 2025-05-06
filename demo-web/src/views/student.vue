<script setup lang="ts">
import { getStudentList } from '@/api/student'
const handleGetList = () =>{
  getStudentList().then(res => {
    console.log('res', res)
  })
}
</script>

<template>
  <div>
    <h1>student</h1>
    <el-button @click="handleGetList">list</el-button>
  </div>
</template>

<style scoped lang="scss">

</style>