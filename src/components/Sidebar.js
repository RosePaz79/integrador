import React from 'react';
import { Layout, Menu as AntMenu, Input, theme } from 'antd';
import { UserOutlined, UploadOutlined } from '@ant-design/icons';
import Logo1 from './core.png';

const { Sider } = Layout;

const Sidebar = ({ collapsed, onMenuClick }) => {
  const {
    token: { colorBtnBg },
  } = theme.useToken();

  const handleMenuItemClick = (e) => {
    onMenuClick(e.key);
  };


  return (
    <Sider
      trigger={null}
      collapsible
      collapsed={collapsed}
      style={{ minHeight: '100vh' }}
    >
     <div style={{ textAlign: 'left'}} display='flex'>
        <img src={Logo1} alt="Logo" width='64px' height='64px'/>
    </div>

      <div className="demo-logo-vertical" />
      <AntMenu
        theme="dark"
        mode="inline"
        defaultSelectedKeys={['1']}
        style={{ paddingTop: '2px' }}
        inlineCollapsed={collapsed}
        onClick={handleMenuItemClick}
      >
        <div style={{ background: colorBtnBg, padding: '8px px' }}>
          <Input
            placeholder="Pesquisar..."
            style={{
              background: 'transparent',
              border: 'no',
              color: 'lightgray',
            }} 
            className="custom-input"
          />
        </div>
        {/* Itens do menu */}
        <AntMenu.Item key="1" icon={<UserOutlined />} onClick={() => onMenuClick('1')}>
          Monitoramento
        </AntMenu.Item>
        <AntMenu.Item key="2" icon={<UploadOutlined />} onClick={() => onMenuClick('2')}>
          Contato
        </AntMenu.Item>
      </AntMenu>
    </Sider>
  );
};

export default Sidebar;
