<template>

    <el-footer style="background: rgb(250, 250, 250);bottom: 0px;width: 100%;height: 45px;">
      <div class="copyright-text">© {{ identityInfoPanel.copyrightYear }} {{ identityInfoPanel.copyrightLabel }}</div>
    </el-footer>
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


