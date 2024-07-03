import { ProLayoutProps } from '@ant-design/pro-components';

/**
 * 默认设置
 */
const Settings: ProLayoutProps & {
  pwa?: boolean;
  logo?: string;
} = {
  navTheme: 'light',
  // 明青
  colorPrimary: '#13C2C2',
  layout: 'top',
  contentWidth: 'Fixed',
  fixedHeader: false,
  fixSiderbar: true,
  splitMenus: false,
  siderMenuType: 'sub',
  title: '嘉宝 API',
  pwa: true,
  logo: 'https://vip.helloimg.com/i/2024/07/03/6684bc378d613.png',
  iconfontUrl: '',
};

export default Settings;
