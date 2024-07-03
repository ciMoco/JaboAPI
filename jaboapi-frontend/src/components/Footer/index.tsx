import { GithubOutlined } from '@ant-design/icons';
import { DefaultFooter } from '@ant-design/pro-components';
import '@umijs/max';
import React from 'react';

const Footer: React.FC = () => {
  const defaultMessage = '恩嗯🧸';
  const currentYear = new Date().getFullYear();
  return (
    <DefaultFooter
      style={{
        background: 'none',
      }}
      copyright={`${currentYear} ${defaultMessage}`}
      links={[
        {
          key: 'github',
          title: (
            <>
              <GithubOutlined /> 项目源码
            </>
          ),
          href: 'https://github.com/ynjabo77/JaboAPI',
          blankTarget: true,
        },
        {
          key: '4399',
          title: '4399走着？',
          href: 'https://4399.com',
          blankTarget: true,
        },
      ]}
    />
  );
};
export default Footer;
