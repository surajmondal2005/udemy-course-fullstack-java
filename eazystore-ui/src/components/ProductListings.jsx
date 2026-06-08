import { useState,useMemo} from "react";
import React from "react";
import ProductCard from "./ProductCard";
import SearchBox from "./SearchBox";
import DropDown from "./DropDown";
const sortList = ["Popularity", "Price Low to High", "Price High to Low"];

export default function ProductListings({ products }) {
  const [searchText, setSearchText] = useState("");
  const [selectedSort, setSelectedSort] = useState("Popularity");
  function handleSearchChange(inputSearch) {
    setSearchText(inputSearch);
  }
  function handleSortChange(sortType) {
    setSelectedSort(sortType);
  }
  const filteredAndSortedProducts = useMemo(() => {
    const filteredProducts = products.filter((product) => {
      return product.name.toLowerCase().includes(searchText.toLowerCase());
    });

    const sortedProducts = filteredProducts.slice().sort((a, b) => {
      if (selectedSort === "Price Low to High") return a.price - b.price;
      if (selectedSort === "Price High to Low") return b.price - a.price;
      else return b.popularity - a.popularity;
      
    });
  return sortedProducts;}, [products, searchText, selectedSort]);
  

  return (
    <div className="max-w-[1152px] mx-auto">
      <div>
        <SearchBox
          label="Search"
          placeholder="Search Products"
          value={searchText}
          handleSearch={handleSearchChange}
        />
        <DropDown
          label="Sort By"
          options={sortList}
          selectedValue={selectedSort}
          handleSort={handleSortChange}
        />
      </div>
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-y-8 gap-x-6 py-12">
        {filteredAndSortedProducts.length > 0 ? (
          filteredAndSortedProducts.map((product) => (
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
