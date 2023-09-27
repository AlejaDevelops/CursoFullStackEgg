import { useEffect, useRef } from "react"
import { useForm } from "../hooks/useForm"

export const FormularioComponent = () => {

    const focusRef = useRef()

    const initialForm = {
        userName: '',
        email: '',
        password: ''

    }

    const { formState, userName, email, password, onInputChange } = useForm(initialForm)

    //const { userName, email, password } = formState

    const onSubmit = (event) => {
        event.preventDefault() //Para que no se acualice la página
        console.log(formState)
    }

    useEffect(() => {
        focusRef.current.focus()
    }, [])


    return (
        <form onSubmit={onSubmit}>
            <div className="form-group">
                <label htmlFor="userName" >User name</label>
                <input
                    type="userName"
                    className="form-control"
                    name="userName"
                    placeholder="Enter user name"
                    value={userName}
                    onChange={onInputChange}
                />
            </div>
            <div className="form-group">
                <label htmlFor="email">Email</label>
                <input

                    type="email"
                    className="form-control"
                    name="email"
                    placeholder="Enter email"
                    value={email}
                    onChange={onInputChange}
                />
            </div>
            <div className="form-group">
                <label htmlFor="password">Password</label>
                <input
                    ref={focusRef}
                    type="password"
                    className="form-control"
                    name="password"
                    placeholder="Enter password"
                    value={password}
                    onChange={onInputChange}
                />
            </div>
            <button type="submit" className="btn btn-primary">Enviar</button>
        </form>
    )
}
