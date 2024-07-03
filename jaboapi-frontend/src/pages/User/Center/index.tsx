import { PageContainer } from '@ant-design/pro-components';
import { useEffect, useState } from 'react';
import React from 'react';
import { Avatar, Button, Card, Col, message, Row, Tooltip } from 'antd';
import {
  getLoginUserUsingGet,
  updateUserKeyUsingPost,
  userSignUsingPost,
} from '@/services/jaboapi-backend/userController';

/**
 * 个人中心
 * @constructor
 */
const Index: React.FC = () => {
  const [showKeys, setShowKeys] = useState(false); // 状态用于控制是否显示公钥和私钥
  const [userInfo, setData] = useState<API.UserVO>();
  const imagePath = '/static/zhu.jpg';

  const userData = async () => {
    const res = await getLoginUserUsingGet();
    setData(res.data);
  };

  const updateKey = async () => {
    // @ts-ignore
    const res = await updateUserKeyUsingPost({
      id: userInfo.id,
    });
    if (res.code === 0) {
      message.success('更换成功');
      userData();
    } else {
      message.error(res.message);
    }
  };

  const sign = async () => {
    try {
      const res = await userSignUsingPost({ id: userInfo.id });
      if (res.code === 0) {
        message.success('签到成功');
        userData();
      }
    } catch (error) {
      message.error(error.message);
    }
  };

  // 点击“查看”按钮时触发的函数
  const handleViewKeys = () => {
    setShowKeys(true); // 设置 showKeys 状态为 true，以显示公钥和私钥
    setTimeout(() => {
      setShowKeys(false); // 五秒后设置 showKeys 状态为 false，隐藏公钥和私钥
    }, 5000);
  };

  useEffect(() => {
    userData();
  }, []);

  return (
    <PageContainer title="个人中心">
      <Row gutter={[16, 16]}>
        <Col span={12}>
          <Card>
            <div className="container">
              <div className="cardContainer">
                <div className="avatarWrapper">
                  <Avatar
                    size={200}
                    src={userInfo?.userAvatar || 'https://example.com/avatar.jpg'}
                    className="avatar"
                  />
                </div>
                <div className="content">
                  <div className="titleWrapper">
                    <span className="title">用户信息</span>
                  </div>
                  <div className="description">
                    <div className="item">
                      <span className="icon">👤</span>
                      <span>昵称: {userInfo?.userName || '大宝子的小弟'}</span>
                    </div>
                    <div className="item">
                      <span className="icon">🪪</span>
                      <span>账号: {userInfo?.userAccount || '被大宝子隐藏掉了'}</span>
                    </div>
                    <div className="item">
                      <span className="icon">🎖️</span>
                      <span>角色: {userInfo?.userRole || '被大宝子给偷走了'}</span>
                    </div>
                    <div className="item">
                      <span className="icon">🌟</span>
                      <span>积分: {userInfo?.leftNum || '被大宝子吃光了'}</span>
                    </div>
                    {/* 用户信息内容 */}
                    <div className="item">
                      <span className="icon">🔑</span>
                      <span>
                        公钥: {showKeys ? userInfo?.accessKey || '大宝子不让看' : '******'}
                      </span>{' '}
                      {/* 当 showKeys 为 true 时显示公钥 */}
                    </div>
                    <div className="item">
                      <span className="icon">🔑</span>
                      <span>
                        私钥: {showKeys ? userInfo?.secretKey || '大宝子不让看' : '******'}
                      </span>{' '}
                      {/* 当 showKeys 为 true 时显示私钥 */}
                    </div>
                  </div>
                  <Tooltip title="展示 5 秒">
                    <Button
                      type="primary"
                      style={{ right: 10, top: 10 }}
                      icon={<span className="icon">🔓</span>}
                      onClick={handleViewKeys}
                    >
                      查看密钥
                    </Button>{' '}
                    {/* 点击按钮触发 handleViewKeys 函数 */}
                  </Tooltip>
                  <div className="actions">
                    <Tooltip title="换个密钥？">
                      <Button
                        type="primary"
                        style={{ right: 10, top: 15 }}
                        icon={<span className="icon">🗝️</span>}
                        onClick={updateKey}
                      >
                        更换密钥
                      </Button>
                    </Tooltip>
                    <Tooltip title="签到领10积分">
                      <Button
                        type="primary"
                        style={{ top: 15 }}
                        icon={<span className="icon">🙋</span>}
                        onClick={sign}
                      >
                        点击签到
                      </Button>
                    </Tooltip>
                  </div>
                </div>
              </div>
            </div>
          </Card>
        </Col>
        <Col span={12}>
          <img
            src={imagePath} // 这里替换为你的图片路径
            alt="Description of image" // 描述图片的内容
            style={{ width: '100%', height: '466px', marginLeft: '-200px' }}
          />
        </Col>
      </Row>
    </PageContainer>
  );
};

export default Index;
