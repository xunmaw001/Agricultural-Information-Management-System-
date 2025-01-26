const base = {
    get() {
        return {
            url : "http://localhost:8080/ssm9927h/",
            name: "ssm9927h",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/ssm9927h/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "农业信息管理系统"
        } 
    }
}
export default base
