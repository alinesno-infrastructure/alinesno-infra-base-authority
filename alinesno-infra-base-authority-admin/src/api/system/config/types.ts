export interface ConfigVO extends BaseEntity {
  id: number | string;
  configName: string;
  configKey: string;
  configValue: string;
  configType: string;
  remark: string;
}

export interface ConfigForm {
  id: number | string | undefined;
  configName: string;
  configKey: string;
  configValue: string;
  configType: string;
  remark: string;
}

export interface ConfigQuery extends PageQuery {
  configName: string;
  configKey: string;
  configType: string;
}
