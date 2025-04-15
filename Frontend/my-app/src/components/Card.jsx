"use client"
import React from 'react'
import { Button, Card } from 'react-bootstrap'

const CustomCard = () => {
  return (
    <Card style={{width: '18rem'}}>
        <Card.Img variant='top' src></Card.Img>
        <Card.Body>
            <Card.Title>card title</Card.Title>
            <Card.Text>card text</Card.Text>
            <Button variant='primary'>Do someting</Button>
        </Card.Body>
    </Card>

  )
}

export default CustomCard
