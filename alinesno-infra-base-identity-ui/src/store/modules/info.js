import { getIdentityInfo } from '@/api/login'

const useIdentityInfoStore = defineStore('identityInfo',{
    state: () => ({
      systemName: '',
      bannerInfo: '',
      version: '',
      copyrightYear: '',
      copyrightLabel: '',
      portalSite: ''
    }),
    actions: {
      // 获取系统信息
      getIdentityInfo() {
        return new Promise((resolve, reject) => {
          getIdentityInfo().then(res => {

            const info = res.data

            this.systemName = info.systemName 
            this.bannerInfo = info.bannerInfo 
            this.version = info.version 
            this.copyrightYear = info.copyrightYear 
            this.copyrightLabel = info.copyrightLabel 
            this.portalSite = info.portalSite 

            resolve(res)
          }).catch(error => {
            reject(error)
          })
        })
      }
    }
  })

export default useIdentityInfoStore
