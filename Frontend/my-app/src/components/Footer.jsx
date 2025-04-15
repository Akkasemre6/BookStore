import React from 'react'
import './footer.css'

const Footer = () => {
  return (
    <footer>
      <div className="container">
        <div className="row g-4">
            logo
            <p className="mt-4">description</p>
            <div className="d-flex">
                <button className="btn btn-primary btn-lg mb-2 me-3">appstore</button>
                <button className='btn btn-primary btn-lg mb-2 me-3'>playstore</button>
            </div>
        </div>
        
      </div>
    </footer>
  )
}

export default Footer
