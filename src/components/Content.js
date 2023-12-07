import React from 'react';
import { Layout } from 'antd';
import Formulario from './Formulario';
import TableImport from './TableImport';


const { Content } = Layout;




const AppContent = ({ rows, columns, contentKey }) => {
    return (
        <Content style={{
            height: '100%',
            width: '100%',
        }}>

            {contentKey === 'tabela' && (
                 <TableImport dataSource={rows} />
            )}

            {contentKey === 'formulario' && (
                <Formulario />
            )}

        </Content>
    );
};

export default AppContent;
