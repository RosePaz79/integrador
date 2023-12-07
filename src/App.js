import React, { useState, useEffect } from 'react';
import { Layout } from 'antd';
import Sidebar from './components/Sidebar';
import AppHeader from './components/Header';
import AppContent from './components/Content';
import TableImport from './components/TableImport';
import axios from 'axios';


const App = () => {
  const [collapsed, setCollapsed] = useState(false);
  const [rows, setRows] = useState([]);
  const [contentKey, setContentKey] = useState('tabela');

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/Pacientes');
        setRows(response.data);
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
        setRows([]);
      }
    };

    fetchData();
  }, []);

  const toggleCollapse = () => {
    setCollapsed(!collapsed);
  };

  const handleMenuClick = (key) => {
    if (key === '1') {
      setContentKey('tabela');
    } else if (key === '2') {
      setContentKey('formulario');
    } else {
      setContentKey(key)
    }
  };

  return (
    <Layout style={{ minHeight: '100vh' }}>
      <Sidebar collapsed={collapsed} onMenuClick={handleMenuClick} />
      <Layout>
        <AppHeader collapsed={collapsed} onToggleCollapse={toggleCollapse} />
        {contentKey === 'tabela' && (
          <AppContent rows={rows} contentKey={contentKey}>
            {rows && rows.length > 0 ?  (
              <TableImport dataSource={rows} />
            ) : (
              <p>Nenhum dado disponível</p>
            )}
          </AppContent>)}
        {contentKey !== 'tabela' && (
          <AppContent rows={rows} contentKey={contentKey}></AppContent>

        )}

      </Layout>
    </Layout>
  );
};

export default App;
