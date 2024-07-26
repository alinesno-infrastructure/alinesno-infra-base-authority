<template>
   <div class="app-container">
    <el-tabs v-model="activeName" class="demo-tabs" @tab-click="handleClick" type="card">
      <el-tab-pane label="接收推送" name="receive">
          <ReceivePush />
      </el-tab-pane>
      <el-tab-pane label="向外广播" name="broadcast">
          <Broadcast />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup>
import { ref } from 'vue'

import ReceivePush from './receivePush';
import Broadcast from './broadcast';

const activeName = ref('receive')

const handleClick = () => {
  console.log(tab, event)
}
</script>
