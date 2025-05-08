<template>
  <div>
    <el-row>
      <el-col :span="12">
        <el-button type="primary" @click="handleAddUser">Add</el-button>
      </el-col>
    </el-row>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column prop="userName" label="userName" width="120" />
      <el-table-column prop="userPassword" label="userPassword" width="120" />
      <el-table-column prop="email" label="email" width="120" />
      <el-table-column label="操作">
        <template #default="{ row }">
          <el-button link type="primary" size="small" @click.prevent="handleEdit(row)">
            Edit
          </el-button>
          <el-button link type="primary" size="small" @click.prevent="handleDeleteUser(row.id)">
            Remove
          </el-button>
        </template>
      </el-table-column>
    </el-table>

    <el-dialog v-model="visible" :title="isEdit ? '编辑' : '新增'" width="500">
      <el-form :model="user">
        <el-form-item label="Promotion userName">
          <el-input v-model="user.userName" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Promotion userPassword">
          <el-input v-model="user.userPassword" autocomplete="off" />
        </el-form-item>
        <el-form-item label="Promotion email">
          <el-input v-model="user.email" autocomplete="off" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button @click="visible = false">Cancel</el-button>
          <el-button type="primary" @click="handleUpdatedUser"> {{ isEdit ? '更新' : '新增' }} </el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>
<script setup lang="ts">
import { addUser, getUser, updatedUser, deleteUser } from "@/api/user";
import { ref, reactive } from "vue";
const tableData = ref([]);
const visible = ref(false);
const isEdit = ref(false);
const user = reactive({
  userId: null,
  userName: "",
  userPassword: "",
  email: "",
});
const handleAddUser = () => {
  visible.value = true;
  isEdit.value = false;
};
const handleDeleteUser = (id: number) => {
  deleteUser(id).then((res) => {
    console.log(res);
  });
};
const handleEdit = (row: any) => {
  visible.value = true;
  isEdit.value = true;
  getUser(row.id).then((res) => {
    console.log(res);
    Object.assign(user, res.data);
  });
  // Object.assign(user, row);
};
const handleUpdatedUser = async () => {
  try {
    const res = isEdit.value ? await updatedUser(user) : await addUser(user);
    console.log(res);
  } catch (error) {
  } finally {
    visible.value = false;
    resetUser();
  }
};
const resetUser = () => {
  user.userId = null;
  user.userName = "";
  user.userPassword = "";
  user.email = "";
};
</script>
