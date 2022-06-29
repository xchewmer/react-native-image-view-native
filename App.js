import { StyleSheet, View } from 'react-native';
import React from 'react';

import { ReactNativeZoomableView } from '@openspacelabs/react-native-zoomable-view';

import NativeView from './NativeView';

const App = () => {
  return (
    <View
      style={{
        width: '100%',
        height: '100%',
        justifyContent: 'center',
        alignItems: 'center'
      }}
    >
      <ReactNativeZoomableView
        maxZoom={1.6}
        minZoom={0.8}
        zoomStep={0.1}
        initialZoom={1.2}
        bindToBorders={true}
        style={{
          padding: 10,
        }}
        contentHeight={1600}
        contentWidth={2000}
        onSingleTap={(e, z) => console.log(z)}
      >
        <View
          style={{
            width: '100%',
            height: '100%',
            justifyContent: 'flex-start',
            alignItems: 'center',
          }}
        >
          <NativeView
            onUpdate={(e) => {
              console.log(e.nativeEvent)
            }}
            style={{
              height: 1500,
              width: 1500,
            }}
          />
        </View>
      </ReactNativeZoomableView>
    </View >
  )
}

export default App;

const styles = StyleSheet.create({});