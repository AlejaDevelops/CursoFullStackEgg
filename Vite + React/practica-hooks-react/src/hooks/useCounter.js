import { useState } from "react";

export const useCounter = (initialValue = 0) => {
  const [counter, setCounter] = useState(initialValue);

  const increment = (val = 1) => {
    setCounter(counter + val)
  };

  const decrement = (val = 1, band = true) => {
    if (!band && counter>0) return setCounter(counter - val)
  };

  const reset = () => {
    setCounter(0)
  }

  return { counter, increment, decrement, reset }
}
