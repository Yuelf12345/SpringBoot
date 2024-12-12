<script lang="ts" setup>
import { get1, get2, post1, post2, post3, upload } from '@/api/index'
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

// 文件
const onUpload = (params: any) => {
  console.log('params', params)
  const fileObject = params.file
  const file = new FormData()
  file.append('file', fileObject)
  try {
    upload(file).then(res => {
      console.log('res', res)
    })
  } catch (error) {
    console.log(error)
  }
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
    <el-upload class="avatar-uploader" action="" :http-request="onUpload" :show-file-list="false">
      <img v-if="imageUrl" :src="imageUrl" class="avatar" />
      <el-icon v-else class="avatar-uploader-icon">
        <Plus />
      </el-icon>
    </el-upload>
  </div>
</template>