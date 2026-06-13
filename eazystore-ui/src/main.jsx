import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";
import Home from "./components/Home";
import About from "./components/About";
import Contact from "./components/Contact";
import Login from "./components/Login";
import Cart from "./components/Cart";
import ErrorPage from "./components/ErrorPage.jsx";
import { productsLoader } from "./components/Home.jsx";
import { contactAction } from "./components/Contact";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";
import { ToastContainer, Bounce } from "react-toastify";
import ProductDetail from "./components/ProductDetail.jsx";
const routeDefinitions = createRoutesFromElements(
  <Route path="/" element={<App />} errorElement={<ErrorPage />}>
    <Route index element={<Home />} loader={productsLoader} />
    <Route path="/home" element={<Home />} loader={productsLoader} />
    <Route path="/about" element={<About />} />
    <Route path="/contact" element={<Contact />} action={contactAction} />
    <Route path="/login" element={<Login />} />
    <Route path="/cart" element={<Cart />} />
    <Route path= "/products/:productId" element={<ProductDetail/>}/>
  </Route>,
);
const appRouter = createBrowserRouter(routeDefinitions);

// const appRouter = createBrowserRouter([
//   {
//     path: "/",
//     element: <App />,
//     errorElement: <ErrorPage/>,
//     children: [
//       {
//         index: true,
//         element: <Home />,
//       },
//       {
//         path: "/home",
//         element: <Home />,
//       },
//       {
//         path: "/about",
//         element: <About />,
//       },
//       {
//         path: "/contact",
//         element: <Contact />,
//       },
//       {
//         path: "/login",
//         element: <Login />,
//       },
//       {
//         path: "/cart",
//         element: <Cart />,
//       },
//     ],
//   },
// ]);

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <RouterProvider router={appRouter} />
    <ToastContainer
      position="top-center"
      autoClose={3000}
      hideProgressBar={false}
      newestOnTop={false}
      draggable
      pauseOnHover
      theme={localStorage.getItem("theme") === "dark" ? "dark" : "light"}
      transition={Bounce}
    />
  </StrictMode>,
);
