import PageHeading from "./PageHeading";
import ProductListings from "./ProductListings";
import apiClient from "../api/apiClient";
import {useState,useEffect} from "react";
import { useLoaderData } from "react-router-dom";


// Hooks
export default function Home() {
  const products = useLoaderData();
  // const [products, setProducts] = useState([]);
  // const [loading, setLoading] = useState(true);
  // const [error, setError] = useState(null);

  // // Run once when the component mounts
  // // Mounting is the process of creating and adding the component into DOM
  // useEffect(() => {
  //   fetchProducts();
  // }, []);

  // const fetchProducts = async () => {
  //   try {
  //     setLoading(true);
  //     const response = await apiClient.get("/products"); // Axios GET Request
  //     setProducts(response.data); // Update products state with fetched data
  //   } catch (error) {
  //     setError(
  //       error.response?.data?.message ||
  //         "Failed to fetch products. Please try again."
  //     ); // Extract error message if available
  //   } finally {
  //     setLoading(false);
  //   }
  // };

    return<div className="home-container ">
        
            <PageHeading title="Explore Eazy Stickers">
                Add a touch of creativity to your space with ou wide range of fun and
                unique stickers.Perfect for any occassion.

            </PageHeading>

            <ProductListings products={products}/>
        
    </div>




}
export async function productsLoader(){
  try {
      
      const response = await apiClient.get("/products"); // Axios GET Request
      return response.data
    } catch (error) {
      
    } 

}