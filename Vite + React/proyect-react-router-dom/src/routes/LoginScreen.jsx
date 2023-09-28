import { useContext } from "react"
import { useForm } from "../hooks/useForm"
import { UserContext } from "../context/UserContext"

export const LoginScreen = () => {

    const initialForm = {
        name: '',
        tecnologia: '',
        email: '',
        rrss: ''
    }

    const { formState, name, tecnologia, email, rrss, onInputChange } = useForm(initialForm)

    const {setUser} = useContext(UserContext)

    const onSubmit = (event) => {
        event.preventDefault()
        setUser(formState)
    }

    return (
        <>
            <form className="container" onSubmit={onSubmit}>
                <div className="form-group">
                    <label htmlFor="name">Nombre</label>
                    <input
                        type="text"
                        className="form-control"
                        name="name"
                        value={name}
                        onChange={onInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="tecnologia">Tecnologia</label>
                    <input
                        type="text"
                        className="form-control"
                        name="tecnologia"
                        value={tecnologia}
                        onChange={onInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="email">Email</label>
                    <input
                        type="text"
                        className="form-control"
                        name="email"
                        value={email}
                        onChange={onInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="rrss">Redes sociales</label>
                    <input
                        type="text"
                        className="form-control"
                        name="rrss"
                        value={rrss}
                        onChange={onInputChange}
                    />
                </div>
                <button type="submit" className="btn btn-primary">Registrar usuario</button>
            </form>
        </>
    )
}
