import React from "react"

export const Incrementar = React.memo(({ incrementar }) => {

  console.log('Se está redibujando el botón')

  return (

    <button className="btn btn-primary" onClick={() => incrementar(10)}>+10</button>

  )
}
)
