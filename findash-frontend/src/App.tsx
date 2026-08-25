import { useState, useEffect} from 'react'
import axios from 'axios'
import './App.css'

type HealthResponse = {
  status: string
}

function App() {
  const[status, setStatus] = useState<string>('Loading...')
  const[error, setError] = useState <string | null>(null)

  useEffect(() => {
    axios
      .get<HealthResponse>('http://localhost:8080/actuator/health')
      .then((response) =>{
        setStatus(response.data.status)
        setError(null)
      })
      .catch((err)=> {
        setStatus('Unable to connect to the server')
        setError(err.message ?? 'Failed to reach backend')
      }) 
      },[])

      return (
        <main style={{ padding: '2rem', fontFamily: 'system-ui, sans-serif'}}>
          <h1>FinDash</h1>
          <p>Backend Status: <strong>{status}</strong></p>
          {error && <p style={{ color:'crimson'}}>{error}</p>}
          <p>Timestamp: {new Date().toLocaleString()}</p>
        </main>
      )
}

export default App
