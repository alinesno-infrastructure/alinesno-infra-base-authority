import type * as ep from 'element-plus';
declare global {
 type ElTagType = '' | 'success' | 'warning' | 'info' | 'danger' | 'default' | 'primary';
 type ElFormInstance = InstanceType<typeof ep.ElForm>;
 type ElTableInstance = InstanceType<typeof ep.ElTable>;
 type ElTreeInstance = InstanceType<typeof ep.ElTree>;
 type ElTreeSelectInstance = InstanceType<typeof ep.ElTreeSelect>;
 type ElSelectInstance = InstanceType<typeof ep.ElSelect>;
 type ElUploadInstance = InstanceType<typeof ep.ElUpload>;
 type ElCardInstance = InstanceType<typeof ep.ElCard>;
 type ElDialogInstance = InstanceType<typeof ep.ElDialog>;
 type ElInputInstance = InstanceType<typeof ep.ElInput>;
 type ElInputNumberInstance = InstanceType<typeof ep.ElInputNumber>;
 type ElRadioInstance = InstanceType<typeof ep.ElRadio>;
 type ElRadioGroupInstance = InstanceType<typeof ep.ElRadioGroup>;
 type ElRadioButtonInstance = InstanceType<typeof ep.ElRadioButton>;
 type ElCheckboxInstance = InstanceType<typeof ep.ElCheckbox>;
 type ElCheckboxGroupInstance = InstanceType<typeof ep.ElCheckboxGroup>;
 type ElSwitchInstance = InstanceType<typeof ep.ElSwitch>;
 type ElDatePickerInstance = InstanceType<typeof ep.ElDatePicker>;
 type ElTimePickerInstance = InstanceType<typeof ep.ElTimePicker>;
 type ElTimeSelectInstance = InstanceType<typeof ep.ElTimeSelect>;
 type ElCascaderInstance = InstanceType<typeof ep.ElCascader>;
 type ElColorPickerInstance = InstanceType<typeof ep.ElColorPicker>;
 type ElRateInstance = InstanceType<typeof ep.ElRate>;
 type ElSliderInstance = InstanceType<typeof ep.ElSlider>;
 type ElScrollbarInstance = InstanceType<typeof ep.ElScrollbar>;

 type TransferKey = ep.TransferKey;
 type CheckboxValueType = ep.CheckboxValueType;
 type ElFormRules = ep.FormRules;
 type DateModelType = ep.DateModelType;
 type UploadFile = typeof ep.UploadFile;
}
