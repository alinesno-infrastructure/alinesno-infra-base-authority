<template>

    <el-header style="z-index: 100;height: 45px;background: #fff;border-bottom: 0px solid #e5e5e5;">
      <div>
        <div style="float: left;font-size: 30px;color:#fff;margin-top: 5px;">
          <img :src="identityInfoPanel.logo" style="width:35px" alt="">
        </div>
        <div class="banner-text">
          {{ identityInfoPanel.systemName }}
        </div>
        <a :href="identityInfoPanel.portalSite"
           target="_blank"
           style="float: right;font-weight: 500;font-size: 13px;margin-top: 14px;color:#222;">
          <i class="fas fa-link"></i> 官网
        </a>
      </div>
    </el-header>

</template>

<script setup>

const props = defineProps({
  identityInfoPanel: {
    type: Object,
    default: () => {
      return {
        logo: '',
        systemName: '',
        portalSite: ''
      }
    }
  }
})

</script>

<style scoped lang="scss">
</style>


