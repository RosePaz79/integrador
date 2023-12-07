import React, { useState, useEffect } from 'react';
import { Table } from 'antd';

const TableImport = () => {
  const [dataSource, setDataSource] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch('http://localhost:8080/Pacientes');
        const data = await response.json();
        setDataSource(data); 
      } catch (error) {
        console.error('Erro ao buscar dados:', error);
      }
    };

    const interval = setInterval(fetchData, 1000);

    return () => clearInterval(interval);
  }, []);

    const columns = [
      {
        title: 'ID',
        dataIndex: 'id',
        key: 'id',
      },
      {
        title: 'Nome',
        dataIndex: 'nome',
        key: 'nome',
      },
      {
        title: 'Batimentos Cardiacos',
        dataIndex: 'batimentos',
        key: 'batimentos',
      },
      {
        title: 'Temperatura',
        dataIndex: 'temperatura',
        key: 'temperatura',
      },
      {
        title: 'Pressão Arterial',
        dataIndex: 'pressao',
        key: 'pressao',
      },
      {
        title: 'Codigo Aparelho',
        dataIndex: 'codigoreferencia',
        key: 'codigoreferencia',
      },
    ];
  
    return (
      <Table
        columns={columns}
        dataSource={dataSource}
        scroll={{
          y: 500,
        }}
      />
    );
  };
  

export default TableImport;