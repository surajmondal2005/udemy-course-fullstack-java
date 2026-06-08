import { useState } from "react";
import React from "react";
import ProductCard from "./ProductCard";
import SearchBox from "./SearchBox";

export default function ProductListings({ products }) {
  const [searchText, setSearchText] = useState("");
  function handleSearchChange(inputSearch){
    setSearchText(inputSearch);

  }
  const filteredProducts = products.filter(
    (product)=>{
      return product.name.toLowerCase().includes(searchText.toLowerCase())
    }

  )

  return (
    <div className="max-w-[1152px] mx-auto">
      <div>
        <SearchBox
          label="Search"
          placeholder="Search Products"
          value={searchText}
          handleSearch={handleSearchChange}
        />
      </div>
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-y-8 gap-x-6 py-12">
        {filteredProducts.length > 0 ? (
          filteredProducts.map((product) => (
            <ProductCard key={product.productId} product={product} />
          ))
        ) : (
          <p className="text-center font-primary font-bold text-lg text-primary">
            No products found
          </p>
        )}
      </div>
    </div>
  );
}
