export interface LoginInfoVO {
  id: string | number;
  groupId: string | number;
  userName: string;
  status: string;
  ipaddr: string;
  loginLocation: string;
  browser: string;
  os: string;
  msg: string;
  loginTime: string;
}

export interface LoginInfoQuery extends PageQuery {
  ipaddr: string;
  userName: string;
  status: string;
  orderByColumn: string;
  isAsc: string;
}
