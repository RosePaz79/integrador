import React, { useState } from 'react';
import { Layout, Button, Modal, Form, Input } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import axios from 'axios';
import { DatePicker } from 'antd';


const { Header } = Layout;

const AppHeader = ({ collapsed, onToggleCollapse }) => {
  const [showPatientForm, setShowPatientForm] = useState(false);
  const [showDeviceForm, setShowDeviceForm] = useState(false);
  const [successModalVisible, setSuccessModalVisible] = useState(false);
  const [isSubmitting, setIsSubmitting] = useState(false);


  const showPatientModal = () => {
    setShowPatientForm(true);
  };

  const showDeviceModal = () => {
    setShowDeviceForm(true);
  };

  const [formData, setFormData] = useState({
    nome: '',
    aparelho: '',
    temperatura: '',
    batimentos: '',
    pressao: '',
  });

  const handleInputChange = (fieldnome, value) => {
    setFormData({
      ...formData,
      [fieldnome]: value,
    });
  };

  const handleCancelInPatientForm = () => {
    setShowPatientForm(false);
    setFormData({
      nome: '',
      aparelho: '',
      temperatura: '',
      batimentos: '',
      pressao: '',
    });
  };
  
  const handleOkInPatientForm = () => {
    axios
      .post('http://localhost:8080/Pacientes', formData)
      .then(response => {
        console.log('Dados enviados com sucesso:', response.data);
        setShowPatientForm(false);
        setFormData({
          nome: '',
          aparelho: '',
          temperatura: '',
          batimentos: '',
          pressao: '',
        });
        setSuccessModalVisible(true);
      })
      .catch(error => {
        console.error('Erro ao enviar dados:', error);
      })
      .finally(() => {
        setIsSubmitting(false);
      });
  };

  const handleCancelInSuccessModal = () => {
    setSuccessModalVisible(false);
  };
  
  const handleOkInSuccessModal = () => {
    setSuccessModalVisible(false);
  };
  
  const successModal = (
    <Modal
      title="Operação concluída"
      visible={successModalVisible}
      onCancel={handleCancelInSuccessModal}
      onOk={handleOkInSuccessModal}
      okButtonProps={{ loading: isSubmitting }}
    >
      <p>Sua operação foi concluída com sucesso!</p>
    </Modal>
  );


  const handleDeviceForm = () => {
  const deviceFormData = {
    codigo: 'Valor do código',
    data: 'Valor da data',
  };

  axios.post('sua_url_da_api_para_dispositivo', deviceFormData)
    .then(response => {
      console.log('Dados do dispositivo enviados com sucesso:', response.data);
      setShowDeviceForm(false);
    })
    .catch(error => {
      console.error('Erro ao enviar dados do dispositivo:', error);
    });
};

const patientForm = (
  <Modal
    title="Paciente"
    visible={showPatientForm}
    onCancel={handleCancelInPatientForm}
    footer={[
      <Button key="cancel" onClick={handleCancelInPatientForm}>
        Cancelar
      </Button>,
      <Button key="submit" type="primary" onClick={handleOkInPatientForm}> {/* Corrigido */}
        OK
      </Button>,
    ]}
  >
        <Form layout="vertical">
        <Form.Item label="Nome">
          <Input placeholder="Nome do paciente"
          value={formData.nome}
          onChange={(e) => handleInputChange('nome', e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Aparelho">
          <Input placeholder="Tipo de aparelho" 
          value={formData.aparelho}
          onChange={(e) => handleInputChange('aparelho', e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Temperatura">
          <Input placeholder="Temperatura do paciente" 
          value={formData.temperatura}
          onChange={(e) => handleInputChange('temperatura', e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Batimentos">
          <Input placeholder="Batimentos do paciente" 
          value={formData.batimentos}
          onChange={(e) => handleInputChange('batimentos', e.target.value)}
          />
        </Form.Item>
        <Form.Item label="Pressão">
          <Input placeholder="Pressão do paciente" 
          value={formData.pressao}
          onChange={(e) => handleInputChange('pressao', e.target.value)}
          />
        </Form.Item>
      </Form>
    </Modal>
  );

  const deviceForm = (
    <Modal
      title="Aparelho"
      visible={showDeviceForm}
      onCancel={handleDeviceForm}
      footer={[<Button key="cancel" onClick={handleDeviceForm}>
        Cancelar
      </Button>,
      <Button key="submit" type="primary" onClick={handleDeviceForm}>
        OK
      </Button>,]}
    >
      <Form layout="vertical">
        <Form.Item label="Código">
          <Input placeholder="Código do aparelho" />
        </Form.Item>
        <Form.Item label="Data">
          <DatePicker style={{ width: '100%' }} />
        </Form.Item>
      </Form>
    </Modal>
  );

  return (
    <Header style={{ padding: 0 }}>
      {successModal}
      {patientForm}
      {deviceForm}
      <Button
        type="text"
        icon={<PlusOutlined />}
        onClick={showPatientModal}
        style={{ fontSize: '16px', width: 64, height: 64, color: 'lightgreen' }}
      />
      <Button
        type="text"
        icon={<PlusOutlined />}
        onClick={showDeviceModal}
        style={{ fontSize: '16px', width: 64, height: 64, color: 'lightgreen' }}
      />
    </Header>
  );
};

export default AppHeader;
