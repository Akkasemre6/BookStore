import React from 'react'
import { Container, Navbar, NavbarBrand, NavbarToggle, NavLink, NavbarCollapse, Nav, NavDropdown, NavDropdownItem, NavDropdownDivider } from 'react-bootstrap'

function CustomNavbar() {
  return (
    <Navbar expand="lg" className="bg-body-tertiary">
      <Container>
        <NavbarBrand href="#home">React-Bootstrap</NavbarBrand>
        <NavbarToggle aria-controls="basic-navbar-nav" />
        <NavbarCollapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavLink href="#home">Home</NavLink>
            <NavLink href="#link">Link</NavLink>
            <NavDropdown title="Dropdown" id="basic-nav-dropdown">
              <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
              <NavDropdownItem href="#action/3.2">
                Another action
              </NavDropdownItem>
              <NavDropdownItem href="#action/3.3">Something</NavDropdownItem>
              <NavDropdownDivider />
              <NavDropdownItem href="#action/3.4">
                Separated link
              </NavDropdownItem>
            </NavDropdown>
          </Nav>
        </NavbarCollapse>
      </Container>
    </Navbar>
  )
}

export default CustomNavbar
