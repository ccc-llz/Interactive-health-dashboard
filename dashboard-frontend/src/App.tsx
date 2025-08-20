import { useState } from 'react'
import { Routes, Route } from 'react-router-dom'
import SideBar from './components/sidebar'
import Home from './pages/Home'
import ChartDemo from './pages/ChartDemo'

function App() {
  return (
    <>
      <div className="fixed w-full h-full bg-gradient-to-br from-sky-50 to-blue-100 flex items-center py-2">
        <SideBar className='max-w-[200px] my-2 ml-2'/>
        <div id='dashboard' className='w-full h-full my-2 bg-white/70 rounded-2xl backdrop-blur-xl m-2 p-2 shadow-xl/5 backdrop-saturate-200'>
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path='/chart-demo' element={<ChartDemo />} />
          </Routes>
        </div>
      </div>
    </>
  )
}

export default App
