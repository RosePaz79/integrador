import React,  { useState } from 'react';
import { Button, Form, Input, InputNumber } from 'antd';
import axios from 'axios';


const layout = {
  labelCol: {
    span: 8,
  },
  wrapperCol: {
    span: 16,
  },
};




/* eslint-disable no-template-curly-in-string */
const validateMessages = {
  required: '${label} is required!',
  types: {
    email: '${label} is not a valid email!',
    number: '${label} is not a valid number!',
  },
  number: {
    range: '${label} must be between ${min} and ${max}',
  },
};


const Formulario = ({ rows }) => {
    const [form] = Form.useForm();
  
    const onFinish = async (values) => {
      try {
        await axios.post('http://localhost:8080/Pacientes', values);
        console.log('Dados enviados:', values);
      } catch (error) {
        console.error('Erro ao enviar dados:', error);
      }
    };
  
    return (
      <Form
        {...layout}
    name="nest-messages"
    onFinish={onFinish}
    style={{
      maxWidth: 600,
    }}
    validateMessages={validateMessages}
  >
    <Form.Item
      name={['user', 'name']}
      label="Nome"
      rules={[
        {
          required: true,
        },
      ]}
    >
      <Input />
    </Form.Item>
    <Form.Item
      name={['user', 'aparelho']}
      label="Aparelho"
      rules={[
        {
          type: 'numeric',
          required: true,
        },
      ]}
    >
      <Input />
    </Form.Item>
    <Form.Item
      name={['user', 'temperatura']}
      label="Temperatura"
      rules={[
        {
          type: 'number',
          min: 0,
          max: 99,
        },
      ]}
    >
      <InputNumber />
    </Form.Item>
    <Form.Item
      name={['user', 'batimentos']}
      label="Batimentos"
      rules={[
        {
          type: 'number',
          min: 0,
          max: 99,
        },
      ]}
    >
      <InputNumber />
    </Form.Item>
    <Form.Item
      name={['user', 'pressao']}
      label="Pressão"
      rules={[
        {
          type: 'number',
          min: 0,
          max: 99,
        },
      ]}
    >
      <InputNumber />
    </Form.Item>
    

    <Form.Item
      wrapperCol={{
        ...layout.wrapperCol,
        offset: 8,
      }}
    >
      <Button type="primary" htmlType="submit">
        Submit
      </Button>
    </Form.Item>
  </Form>
);
};

export default Formulario;