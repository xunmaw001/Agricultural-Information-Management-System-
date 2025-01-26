export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["新增","查看","修改","删除"],"menu":"用户","menuJump":"列表","tableName":"yonghu"}],"menu":"用户管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["新增","查看","修改","删除"],"menu":"种植户","menuJump":"列表","tableName":"zhongzhihu"}],"menu":"种植户管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"农产品类型","menuJump":"列表","tableName":"nongchanpinleixing"}],"menu":"农产品类型管理"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["新增","查看","修改","删除"],"menu":"农资类型","menuJump":"列表","tableName":"nongzileixing"}],"menu":"农资类型管理"},{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["查看","修改","删除","查看评论"],"menu":"农产品","menuJump":"列表","tableName":"nongchanpin"}],"menu":"农产品管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","修改","删除","查看评论"],"menu":"农资产品","menuJump":"列表","tableName":"nongzichanpin"}],"menu":"农资产品管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["新增","查看","修改","删除"],"menu":"农资技术","menuJump":"列表","tableName":"nongzijishu"}],"menu":"农资技术管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["新增","查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"农业政策","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"农产品列表","menuJump":"列表","tableName":"nongchanpin"}],"menu":"农产品模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"农资产品列表","menuJump":"列表","tableName":"nongzichanpin"}],"menu":"农资产品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"农资技术列表","menuJump":"列表","tableName":"nongzijishu"}],"menu":"农资技术模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"农产品列表","menuJump":"列表","tableName":"nongchanpin"}],"menu":"农产品模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"农资产品列表","menuJump":"列表","tableName":"nongzichanpin"}],"menu":"农资产品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"农资技术列表","menuJump":"列表","tableName":"nongzijishu"}],"menu":"农资技术模块"}],"hasBackLogin":"否","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"用户","tableName":"yonghu"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-pay","buttons":["新增","查看","修改","删除","查看评论"],"menu":"农产品","menuJump":"列表","tableName":"nongchanpin"}],"menu":"农产品管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["新增","查看","修改","删除","查看评论"],"menu":"农资产品","menuJump":"列表","tableName":"nongzichanpin"}],"menu":"农资产品管理"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","删除"],"menu":"已完成订单","tableName":"orders/已完成"},{"appFrontIcon":"cuIcon-brand","buttons":["查看","删除"],"menu":"已退款订单","tableName":"orders/已退款"},{"appFrontIcon":"cuIcon-news","buttons":["查看","删除","物流"],"menu":"已发货订单","tableName":"orders/已发货"},{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除","发货"],"menu":"已支付订单","tableName":"orders/已支付"}],"menu":"订单管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["查看"],"menu":"农产品列表","menuJump":"列表","tableName":"nongchanpin"}],"menu":"农产品模块"},{"child":[{"appFrontIcon":"cuIcon-pic","buttons":["查看"],"menu":"农资产品列表","menuJump":"列表","tableName":"nongzichanpin"}],"menu":"农资产品模块"},{"child":[{"appFrontIcon":"cuIcon-vip","buttons":["查看"],"menu":"农资技术列表","menuJump":"列表","tableName":"nongzijishu"}],"menu":"农资技术模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"种植户","tableName":"zhongzhihu"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
